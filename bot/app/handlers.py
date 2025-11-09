import asyncio
import requests
from aiogram import F, Router
from aiogram.types import Message
from aiogram.filters import CommandStart
from aiogram.fsm.state import State, StatesGroup
from aiogram.fsm.context import FSMContext


from aiogram.types import ReplyKeyboardMarkup, KeyboardButton

class Keyboards:
    main = ReplyKeyboardMarkup(keyboard=[[KeyboardButton(text='Войти в аккаунт')], [KeyboardButton(text='О нас')]], resize_keyboard=True)
    logged_in = ReplyKeyboardMarkup(keyboard=[[KeyboardButton(text='Мои дедлайны')], [KeyboardButton(text='Выйти')]], resize_keyboard=True)

kb = Keyboards()

router = Router()


DEADLINES_API_URL = "https://api.my-deadlines.com/get"

AUTH_API_URL = "https://api.my-deadlines.com/auth"


logged_in_users = {}


class Logining(StatesGroup):
    login = State()
    password = State()


async def authenticate_user(login: str, password: str) -> bool:
    try:
        payload = {'username': login, 'password': password}
        
        response = await asyncio.to_thread(requests.post, AUTH_API_URL, json=payload, timeout=5)
        
        if response.status_code == 200:
            return True
        else:
            print(f"Ошибка аутентификации для '{login}': статус {response.status_code}")
            return False
            
    except requests.exceptions.RequestException as e:
        print(f"Ошибка сети при запросе аутентификации: {e}")
        return False

async def fetch_deadlines(login: str):
    try:
        params = {'username': login}
        response = await asyncio.to_thread(requests.get, DEADLINES_API_URL, params=params, timeout=5)
        if response.status_code == 200:
            return response.json()
        else:
            print(f"Ошибка от API дедлайнов: статус {response.status_code}")
            return None
    except requests.exceptions.RequestException as e:
        print(f"Ошибка сети при запросе к API дедлайнов: {e}")
        return None



@router.message(CommandStart())
async def cmd_start(message: Message):
    await message.answer('Добро пожаловать в центр уведомлений по дедлайнам ваших работ!', reply_markup=kb.main)

@router.message(F.text == 'Войти в аккаунт')
async def start_login(message: Message, state: FSMContext):
    await state.set_state(Logining.login)
    await message.answer('Введите ваш логин')

@router.message(Logining.login)
async def process_login(message: Message, state: FSMContext):

    await state.update_data(login=message.text)
    await state.set_state(Logining.password)
    await message.answer('Отлично! Теперь введите пароль')

@router.message(Logining.password)
async def check_password(message: Message, state: FSMContext):

    user_data = await state.get_data()
    user_login = user_data.get('login')
    user_password = message.text

    await state.clear()
    
    await message.answer("Проверяем ваши данные...")

    is_authenticated = await authenticate_user(user_login, user_password)

    if is_authenticated:
        logged_in_users[message.from_user.id] = user_login
        await message.answer(f'Вы успешно вошли как "{user_login}"!', reply_markup=kb.logged_in)
    else:
        await message.answer('Неверный логин или пароль! Попробуйте еще раз.', reply_markup=kb.main)



@router.message(F.text == 'Мои дедлайны')
async def get_my_deadlines(message: Message):
    user_id = message.from_user.id
    if user_id in logged_in_users:
        user_login = logged_in_users[user_id]
        await message.answer("Загружаю ваши дедлайны, пожалуйста, подождите...")
        
        deadlines = await fetch_deadlines(user_login)
        if deadlines is None:
            await message.answer("Не удалось получить данные. Попробуйте позже.")
        elif not deadlines:
            await message.answer("🎉 У вас нет предстоящих дедлайнов!")
        else:
            response_text = "<b>Ваши актуальные дедлайны:</b>\n\n"
            for item in deadlines:
                title = item.get("title", "Без названия")
                due_date = item.get("due_date", "Не указана")
                response_text += f"• <b>{title}</b> — до {due_date}\n"
            await message.answer(response_text, parse_mode='HTML')
    else:
        await message.answer("Эта функция доступна только после входа в аккаунт.", reply_markup=kb.main)

@router.message(F.text == 'Выйти')
async def logout(message: Message):
    user_id = message.from_user.id
    if user_id in logged_in_users:
        del logged_in_users[user_id]
        await message.answer("Вы успешно вышли из аккаунта.", reply_markup=kb.main)
    else:
        await message.answer("Вы не вошли в аккаунт.", reply_markup=kb.main)