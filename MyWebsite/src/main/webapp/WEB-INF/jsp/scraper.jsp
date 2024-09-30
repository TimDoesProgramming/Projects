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
	<meta name="author" content="Timothy Alban">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
	<body>


    <form id="inputForm">
        <label for="input">Submit the website link to scrape</label>
        <input type="text" id="baseUrlInput" name="baseUrlInput">
        <br><br>
        <input type="text" id="depthInput" name="depthInput">
        <label for="dropdown">Choose an option:</label>
            <select id="dropdown" name="options">
                <option value="1">Say Hello to Christine</option>
                <option value="2">Say goodbye to Christine 2</option>
                <option value="3">poop like christine</option>
                <option value="4">naynay on them</option>
            </select>
            <br><br>

        <button type="submit">Submit</button>
    </form>



    <div id="spinner" class="spinner"></div>
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