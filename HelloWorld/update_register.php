<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "userdb";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['update'])) {
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $confirmPassword = $_POST['confirmPassword'];

    // Validate password matching
    if ($password != $confirmPassword) {
        echo "Passwords do not match";
        exit(); // Stop execution
    }

    // Prepare and bind SQL statement for update
    $stmt = $conn->prepare("UPDATE user_info SET email=?, password=? WHERE username=?");
    $stmt->bind_param("sss", $email, $password, $username);

    // Execute the statement
    if ($stmt->execute()) {
        echo "Record updated successfully";
    } else {
        echo "Error updating record: " . $stmt->error;
    }

    // Close statement
    $stmt->close();
}

$conn->close();
?>