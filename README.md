REST сервер для работы метеорологической станции. Есть множество датчиков, которые умеют измерять температуру и определять идет дождь или нет. Датчики с помощью POST запроса и передачи в теле JSON могут передавать информацию об измерениях, которая сохраняется в БД.

Основной функционал: 
1. "Регистрация" новых датчиков POST запрос с именем нового датчика, который валидируется на сервере и если датчик с таким именем уже существует, то "регистрация" не происходит, а пользователю возвращаются сообщение об ошибке.
2. Добавление очередного измерения. Если датчика связанного с переданным именем нет в системе, то пользователя возвращается сообщение об ошибке.
3. Получение множества дней, когда был дождь.
4. Получение всех измерений
Все общение происходит в формате JSON. Для сериализации в JSON используется Jackson. 