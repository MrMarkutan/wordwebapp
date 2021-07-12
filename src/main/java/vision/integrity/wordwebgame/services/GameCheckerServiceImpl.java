package vision.integrity.wordwebgame.services;

import org.springframework.stereotype.Service;
import vision.integrity.wordwebgame.repositories.GameCheckerRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GameCheckerServiceImpl implements GameCheckerService {

    private final GameCheckerRepository gameCheckerRepository;

    public GameCheckerServiceImpl(GameCheckerRepository gameCheckerRepository) {
        this.gameCheckerRepository = gameCheckerRepository;
    }

    @Override
    public List<String> checkList(List<String> inputList) {

        List<String> checkedList = new ArrayList<>();

        //Если список больше 1 значения начинаем проверять, иначе возвращаем
        //исходный массив
        if(inputList.size() > 1){
            String word, nextWord;

            Iterator<String> iter = inputList.iterator();
            //Берем значение из списка и проверяем осталось еще что-то в списке
            word = iter.next();
            while (iter.hasNext()) {
                //Берем следующее значение
                nextWord = iter.next();

                //Если первое значение пустая строка, то останавливаем цикл
                if (word.equals("")){
                    break;
                }

                //Если следующее значение НЕ пустая строка, проверяем дальше
                if (!nextWord.equals("")){

                    //Проверяем последнюю букву значения и первую букву следующего
                    //если совпадают, добавляем в список для возврата
                    if (word.charAt(word.length() - 1) == nextWord.charAt(0)) {
                        checkedList.add(word);
                        //Запоминаем значение для следующей проверки
                        word = nextWord;

                        //Проверяем остались ли еще элементы во входящем списке,
                        //если нету, добавляем значение в возвращаемый список
                        if (!iter.hasNext()) {
                            checkedList.add(word);
                        }
                    } else {
                        //Если буквы не совпадают - добавляем значение в список
                        //и останавливаем цикл
                        checkedList.add(word);
                        break;
                    }
                } else {
                    //Если следующее значение - пустая строка, добавляем значение которое
                    //запомнили и останавливаем цикл
                    checkedList.add(word);
                    break;
                }
            }
        } else {
            checkedList = inputList;
        }
        return checkedList;
    }

}
