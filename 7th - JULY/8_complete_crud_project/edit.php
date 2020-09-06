<?php
require_once "pdo.php";
session_start();

if ( isset($_POST['make']) && isset($_POST['year'])
     && isset($_POST['mileage']) && isset($_POST['model']) ) {

    // Data validation
    if ( strlen($_POST['make']) < 1 || strlen($_POST['year']) < 1
      || strlen($_POST['mileage']) < 1 || strlen($_POST['model']) < 1) {
        $_SESSION['error'] = 'Invalid data';
        header("Location: edit.php?auto_id=".$_POST['auto_id']);
        return; }

    if (is_numeric($_POST['year']) == False || is_numeric($_POST['mileage']) == False) {
        $_SESSION["error"]  = "Mileage and year must be numeric";
        header("Location: edit.php?auto_id=".$_POST['auto_id']);
        return;
    }

    $sql = "UPDATE autos SET make = :mk,
            year = :yr, mileage = :mi, model = :mo
            WHERE auto_id = :auto_id";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(array(
      ':mk' => $_POST['make'],
      ':yr' => $_POST['year'],
      ':mi' => $_POST['mileage'],
      ':mo' => $_POST['model'],
      ':auto_id' => $_POST['auto_id']) ) ;
    $_SESSION['success'] = 'Record updated';
    header( 'Location: index.php' ) ;
    return;
}

// Guardian: Make sure that user_id is present
if ( ! isset($_GET['auto_id']) ) {
  $_SESSION['error'] = "Missing auto_id";
  header('Location: index.php');
  return;
}

$stmt = $pdo->prepare("SELECT * FROM autos where auto_id = :xyz");
$stmt->execute(array(":xyz" => $_GET['auto_id']));
$row = $stmt->fetch(PDO::FETCH_ASSOC);
if ( $row === false ) {
    $_SESSION['error'] = 'Bad value for auto_id';
    header( 'Location: index.php' ) ;
    return;
}

// Flash pattern
if ( isset($_SESSION['error']) ) {
    echo '<p style="color:red">'.$_SESSION['error']."</p>\n";
    unset($_SESSION['error']);
}

$m = htmlentities($row['make']);
$y = htmlentities($row['year']);
$mi = htmlentities($row['mileage']);
$mo = htmlentities($row['model']);
$auto_id = $row['auto_id'];
?>


<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
    integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <title></title>
  </head>
  <body>
    <div class="container">

      <p>Edit User</p>
      <form method="post">

        <label for="make">Make</label>
        <p><input type="text" name="make" value="<?= $m ?>"></p>
        <label for="model">Model</label>
        <p><input type="text" name="model" value="<?= $mo ?>"></p>
        <label for="year">Year</label>
        <p><input type="text" name="year" value="<?= $y ?>"></p>
        <label for="mileage">Mileage</label>
        <p><input type="text" name="mileage" value="<?= $mi ?>"></p>
        <input type="hidden" name="auto_id" value="<?= $auto_id ?>">
        <p><input type="submit" value="Save"/>
        <a href="index.php">Cancel</a></p>

      </form>      
    </div>
  </body>
</html>
