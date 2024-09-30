class FormController {
    constructor() {
        this.form = document.getElementById('inputForm');
        this.inputBox = document.getElementById('baseUrlInput');
        this.depthInput = document.getElementById('depthInput');
        this.spinner = document.getElementById('spinner');
        this.resultDiv = document.getElementById('result');
        this.dropdown = document.getElementById('dropdown');
    }
    initialize() {
        this.form.addEventListener('submit', this.handleSubmit.bind(this));
    }

    handleSubmit(event) {

        event.preventDefault();
        const input = this.inputBox.value;
        const depth = this.depthInput.value;
        const dropdown = this.dropdown.value;
        console.log('Link:', input);
        const encodedOption = encodeURIComponent(dropdown);
        const encodedBaseUrl = encodeURIComponent(input);
        const encodedDepth = encodeURIComponent(depth);

        this.spinner.style.display = 'block';
        this.resultDiv.innerHTML = ''; // Clear previous result
        const url = 'http://localhost:8080/api/link/submitLink?baseUrl=' + encodedBaseUrl+'&depth='+encodedDepth;


        // Make the API call using fetch
        fetch(url, {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                console.log('success:', data);
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
    }

}