В данном коде предусмотрена возможность задать параметризованную сборку в Jenkins, в контексте указания URL удаленного браузера в Selenoid.

Для настройки параметризованного joba в Jenkins нужно указать команду запуска по маске gradle clean test -Dremote_url=*URL вашего удаленного Selenoid*. например, gradle clean test -Dremote_url=@selenoid.autotests.cloud/wd/hub/
 
 
