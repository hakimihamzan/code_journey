<?php
require_once "pdo.php";
session_start();

if ( ! isset($_SESSION["name"]) &&  ! isset($_SESSION["user_id"])  ) {
  die("Not logged in");
  return;
}

if (isset($_POST['cancel']) ) {
  header('Location: index.php');
  return;
}

if ( isset($_POST['delete']) && isset($_POST['profile_id']) ) {
    $sql = "DELETE FROM profile WHERE profile_id = :zip";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(array(':zip' => $_POST['profile_id']));
    $_SESSION['success'] = 'Record deleted';
    header( 'Location: index.php' ) ;
    return;
}

if ( ! isset($_GET['profile_id']) ) {
  $_SESSION['error'] = "Missing profile_id";
  header('Location: index.php');
  return;
}

$stmt = $pdo->prepare("SELECT first_name, last_name, profile_id FROM profile where profile_id = :xyz");
$stmt->execute(array(":xyz" => $_GET['profile_id']));
$row = $stmt->fetch(PDO::FETCH_ASSOC);
if ( $row === false ) {
    $_SESSION['error'] = 'Bad value for profile_id';
    header( 'Location: index.php' ) ;
    return;
}
 ?>

 <!DOCTYPE html>
 <html>
   <head>
     <meta charset="utf-8">
     <title>46ab5450</title>
   </head>
   <body>
     <h1>Deleting Profile</h1>
     <?php
     echo "<p>First name: </p>";
     echo(htmlentities($row['first_name']));
     echo "<p>Last name: </p>";
     echo(htmlentities($row['last_name']));
     echo "<br>";
      ?>
      <p>
     <form method="post">
       <input type="hidden" name="profile_id" value="<?= $row['profile_id'] ?>">
       <input type="submit" value="Delete" name="delete">
       <input type="submit" value="Cancel" name="cancel">
     </form></p>

   </body>
 </html>
