from aiogram.types import (ReplyKeyboardMarkup, KeyboardButton,
                           InlineKeyboardMarkup, InlineKeyboardButton)

main = ReplyKeyboardMarkup(keyboard=[[KeyboardButton(text='Войти в аккаунт')],
                                     [KeyboardButton(text='О нас')]],
                           resize_keyboard=True,
                           input_field_placeholder='Выберите пункт меню...')

logged_in = ReplyKeyboardMarkup(keyboard=[[KeyboardButton(text='Выйти')]],
                           resize_keyboard=True,
                           input_field_placeholder='Выберите пункт меню...')