import service.Service;

public class Main {
    /*Добрый вечер
    Небольшой комментарий по заданию на этапе сдачи.
    В финале понял что допустил глобальную/ключевую ошибку в погоне за "красивым",как мне казалось в тот момент, решением.
    Начал создавать линки(связи между городами) полностью уникальными и впоследствии обрабатывать их на всех этапах с таким же подходом.
    На деле же это привело к усложнению всего и вся на каждом этапе,что в итоге работает против кода и наверное стоило бы
    идти линейно (собирать всю инфо "как есть",обрабатывать всю инфо "как есть" и тд.).Поскольку сроки и так прошли-сдаю в таком виде.

    Поскольку это считается за конечный результат,если возможно-хотел бы узнать что именно было самым слабым элементом
    и требовало улучшения-чтобы на будущее сделать выводы.
    Спасибо.
     */

    public static void main(String[] args) {
        Service service = new Service();
        service.start();
    }
}