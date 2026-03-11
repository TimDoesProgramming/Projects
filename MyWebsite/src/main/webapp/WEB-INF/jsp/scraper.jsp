<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>

<head>
    <title>Projects</title>
    <!-- css files -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.3.1/css/bulma.min.css">
    <link href="<c:url value='/css/styles.css'/>" rel="stylesheet">

    <link type="image/x-icon" href="<c:url value='/img/favicon.png'/>" rel="icon">
    <meta charset="UTF-8">
    <meta name="author" content="Timothy Alban">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <nav class="nav container void-background">
        <div class="nav-right nav-menu">
            <a class="nav-item" href="${pageContext.request.contextPath}..">About</a>
            <a class="nav-item" href="${pageContext.request.contextPath}..#projects">Projects</a>
            <a class="nav-item" href="#social">Social</a>
        </div>
    </nav>

    <div class="projectTitle">
        <h1>Website Scraper
            <h1/>
    </div>
    <div class="center border">
        <form id="inputForm">
            <div class="center">
                <label for="baseUrlInput">Submit the website link to scrape</label>
                <input type="text" id="baseUrlInput" name="baseUrlInput"
                required
                placeholder="https://example.com"
                maxlength="2048">
            </div>
            <br><br>
            <div class="center">
                <label for="depthInput">Choose the depth you would like to search</label>
                <select id="depthInput" name="options">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <br><br>
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>


    <div id="spinner" class="spinner" role="status" aria-live="polite" aria-label="Loading" hidden></div>
    <div id="result"></div>



    <script src="/script/scraperProjectController.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            console.log('DOM fully loaded and parsed');
            const controller = new FormController();
            controller.initialize();
        });
    </script>

</body>

</html>