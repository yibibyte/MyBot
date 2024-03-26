package ru.bot.chat;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Arrays;

public class InlineBot extends TelegramLongPollingBot {
    private final static String BOT_NAME = "";
    private final static String BOT_TOKEN = "";

    public InlineBot() {
        super();
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();

            // Обработка нажатий на кнопки
            switch (data) {
                case "button_1":
                    // Логика для кнопки 1
                    break;
                case "button_2":
                    // Логика для кнопки 2
                    break;
                default:
                    break;
            }

            // Отправка ответа
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(callbackQuery.getMessage().getChatId());
            sendMessage.setText("Вы выбрали: " + data);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public InlineKeyboardMarkup getKeyboard() {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();

        // Добавление кнопок
        keyboard.setKeyboard(Arrays.asList(
                Arrays.asList(
                        InlineKeyboardButton.builder().text("Кнопка 1").callbackData("button_1").build(),
                        InlineKeyboardButton.builder().text("Кнопка 2").callbackData("button_2").build()
                )
        ));

        return keyboard;
    }

    public void sendKeyboard(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Выберите:");
        sendMessage.setReplyMarkup(getKeyboard());

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new InlineBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
