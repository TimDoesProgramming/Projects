<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form id="myForm">
        <label for="dropdown">Choose an option:</label>
        <select id="dropdown" name="options">
            <option value="option1">Option 1</option>
            <option value="option2">Option 2</option>
            <option value="option3">Option 3</option>
            <option value="option4">Option 4</option>
        </select>
        <br><br>
        <button type="submit">Submit</button>
    </form>

    <!-- Spinner Element -->
    <div class="spinner" id="spinner"></div>

    <script>
        document.getElementById('myForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the form from submitting the default way

            const dropdown = document.getElementById('dropdown');
            const selectedOption = dropdown.value;
            const encodedOption= encodeURIComponent(selectedOption);
            console.log('Selected Option:', selectedOption);
            console.log('Encoded Option:', encodedOption);
            const spinner = document.getElementById('spinner');
            url = `http://localhost:8080/api/link/submit?option=` + encodedOption;
            

            // Show the spinner
            spinner.style.display = 'block';

            // Make the API call using fetch
            fetch(url, {
                method: 'GET'
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                // Handle success response

                // Hide the spinner
                spinner.style.display = 'none';
            })
            .catch((error) => {
                console.error('Error:', error);
                // Handle error response

                // Hide the spinner
                spinner.style.display = 'none';
            });
        });
    </script>

	</body>
</html>