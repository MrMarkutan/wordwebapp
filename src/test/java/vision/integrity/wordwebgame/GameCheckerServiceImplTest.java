package vision.integrity.wordwebgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vision.integrity.wordwebgame.services.GameCheckerServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class GameCheckerServiceImplTest {

    @Autowired
    private GameCheckerServiceImpl gcs;

    List<List<String>> inputTestLists = new ArrayList<>();
    List<List<String>> expectedResultsList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        List<String> testList1 = new ArrayList<>(Arrays.asList("fish", "horse", "egg", "goose", "eagle"));
        inputTestLists.add(testList1);
        List<String> expectedList1 = new ArrayList<>(Arrays.asList("fish", "horse", "egg", "goose", "eagle"));
        expectedResultsList.add(expectedList1);

        List<String> testList2 = new ArrayList<>(Arrays.asList("fish", "horse", "snake", "goose", "eagle"));
        inputTestLists.add(testList2);
        List<String> expectedList2 = new ArrayList<>(Arrays.asList("fish", "horse"));
        expectedResultsList.add(expectedList2);

        List<String> testList3 = new ArrayList<>(Arrays.asList("fish", "horse", "", "goose", "eagle"));
        inputTestLists.add(testList3);
        List<String> expectedList3 = new ArrayList<>(Arrays.asList("fish", "horse"));
        expectedResultsList.add(expectedList3);

        List<String> testList4 = new ArrayList<>(Arrays.asList("", "horse", "", "goose", "eagle"));
        inputTestLists.add(testList4);
        List<String> expectedList4 = new ArrayList<>();
        expectedResultsList.add(expectedList4);
    }

    @Test
    void checkList() {
        List<String> actualList;

        //Тест 1 Обычный ввод
        actualList = gcs.checkList(inputTestLists.get(0));
        assertEquals(expectedResultsList.get(0), actualList);
        System.out.println("Test 1 completed");

        //Тест 2 Прерванная последовательность
        actualList = gcs.checkList(inputTestLists.get(1));
        assertEquals(expectedResultsList.get(1), actualList);
        System.out.println("Test 2 completed");

        //Тест 3 Пустое значение в одной из позиций списка
        actualList = gcs.checkList(inputTestLists.get(2));
        assertEquals(expectedResultsList.get(2), actualList);
        System.out.println("Test 3 completed");

        //Тест 4 Пустое значение на первой позиции списка
        actualList = gcs.checkList(inputTestLists.get(3));
        assertEquals(expectedResultsList.get(3), actualList);
        System.out.println("Test 4 completed");

    }
}