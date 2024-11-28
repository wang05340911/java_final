// Display a confirmation dialog before deleting an item
function confirmDeletion(message, url) {
    if (confirm(message)) {
        // Redirect to the provided URL if confirmed
        window.location.href = url;
    }
}

// Validate form inputs to ensure no fields are empty
function validateForm(formId) {
    const form = document.getElementById(formId);
    const inputs = form.querySelectorAll("input, textarea");
    let isValid = true;

    inputs.forEach(input => {
        if (input.value.trim() === "") {
            alert(`The field "${input.name}" cannot be empty.`);
            input.focus();
            isValid = false;
            return false; // Break out of the loop
        }
    });

    return isValid;
}

// Toggle visibility of an element by ID
function toggleVisibility(elementId) {
    const element = document.getElementById(elementId);
    if (element.style.display === "none") {
        element.style.display = "block";
    } else {
        element.style.display = "none";
    }
}

// Highlight the current navigation menu item
function highlightCurrentNav() {
    const links = document.querySelectorAll("nav a");
    const currentUrl = window.location.href;

    links.forEach(link => {
        if (link.href === currentUrl) {
            link.classList.add("active");
        }
    });
}

// Add event listeners for interactive buttons or elements
document.addEventListener("DOMContentLoaded", () => {
    // Example: Add a click listener for a delete button
    const deleteButtons = document.querySelectorAll(".delete-button");
    deleteButtons.forEach(button => {
        button.addEventListener("click", event => {
            event.preventDefault();
            const message = "Are you sure you want to delete this item?";
            const url = button.getAttribute("href");
            confirmDeletion(message, url);
        });
    });
});