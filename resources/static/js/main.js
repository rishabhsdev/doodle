document.getElementById("search").addEventListener("keydown", function (event) {
  // Check if the Enter key is pressed
  if (event.key === "Enter") {
    // Prevent the default form submission
    event.preventDefault();
    // Trigger the form submission
    document.getElementById("myForm").submit();
  }
});
