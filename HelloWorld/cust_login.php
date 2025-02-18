<?php

session_start();

// Database connection
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

// Get the login credentials from the POST request
$email = $_POST['Email'];
$password = $_POST['Password'];

// Prepare and execute the SQL statement to check if the user exists with the provided credentials
$sql = "SELECT * FROM user_info WHERE email = '$email' AND password = '$password'";
$result = $conn->query($sql);

if ($result->num_rows == 1) {
    // User exists, login successful
    $_SESSION['email'] = $email;
    echo "success";
} else {
    // User does not exist or invalid credentials
    echo "failure";
}

$conn->close();
?>