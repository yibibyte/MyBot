package ru.bot.chat;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil {
    public static ReplyKeyboardMarkup createMenu() {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setSelective(true);
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("Вариант 1");
        row1.add("Вариант 2");

        KeyboardRow row2 = new KeyboardRow();
        row2.add("Вариант 3");
        row2.add("Вариант 4");

        keyboard.add(row1);
        keyboard.add(row2);

        replyMarkup.setKeyboard(keyboard);
        return replyMarkup;
    }
}
