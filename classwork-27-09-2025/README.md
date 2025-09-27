1. Для работы с веб-приложениями требуется Application Server - Tomcat, Glassfish, Netty или др.
2. При работе с Tomcat версии 8 и ниже - используются зависимости из javax.servlet, при работе с Tomcat 9 и выше - зависимости jakarta.servlet.
3. Обязательно указать, что приложение собирается как WAR-архив, т.е. `id 'war'` для Gradle или `<packaging>war</packaging>` для Maven.
4. Обязательно создать директорию `/src/main/webapp/WEB-INF/`, в ней файл `web.xml` - дескриптор развёртывания.
5. Виды создаются с расширением `.jsp`, должны находиться где-то внутри `webapp`
6. Для создания сервлета необходимо `extends HttpServlet` и зарегистрировать его (в `web.xml` или `@WebServlet()`)
7. Внутрення переадресация - `rq.getRequestDispatcher("/url").forward(rq, rs)`
8. Добавление атрибутов в запрос - `rq.setAttribute("key", value)`
9. Вывод атрибутов запроса в JSP - `<%= request.getAttribute("key") %>`
10. Для создания формы используется action и method, get - передаёт значения в параметрах запроса, post - в теле запроса.
11. Абсолютные пути - зло. Используйте `${pageContext.request.contextPath}`
12. Чтобы починить кодировку, используйте `rq.setCharacterEncoding(StandartCharsets.UTF-8.name())`
13. Всегда используйте защиту от повторной отправки формы!
14. Заполняйте компонентами servletContext в Listener (`contextInitialized()`), забирайте значения в сервлетах (`init()`)
15. Предусмотрите закрытие ресурсов (`destroy()`)