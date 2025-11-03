### Настройка checkstyle в IDEA
1) Скачать плагин [CheckStyle-IDEA](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea)
2) Settings -> Tools -> Checkstyle
3) Добавить [конфигурационный файл](config/checkstyle.xml)
4) Там же в **Scan Source** выбрать **All Sources (including tests)**
5) Убедиться, что в **Settings** -> **Editor** -> **Inspections** включен **Checkstyle** -> **Checkstyle real-time scan**