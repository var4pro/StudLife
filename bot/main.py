import asyncio
from aiogram import Bot, Dispatcher, F

from app.handlers import router


async def main():
    bot = Bot(token='8583003068:AAEVR3mGIogrYk0k1ljCiZ8Q7N7ucU4OLrM')
    dp = Dispatcher()
    dp.include_router(router)
    await dp.start_polling(bot)


if __name__ == '__main__':
    asyncio.run(main())