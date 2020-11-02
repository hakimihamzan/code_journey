<?php
session_start();
require_once "pdo.php";
require_once "function.php";


if ( ! isset($_SESSION["name"]) &&  ! isset($_SESSION["user_id"])  ) {
  die("Not logged in");
  return;
}

if (isset($_POST['cancel']) ) {
  header('Location: index.php');
  return;
}
#data checking before updated
if ( isset($_POST['first_name']) && isset($_POST['last_name'])
&& isset($_POST['email']) && isset($_POST['headline'])
&& isset($_POST['summary']) ) {

  if ( strlen($_POST['first_name']) < 1 || strlen($_POST['last_name']) < 1
  || strlen($_POST['email']) < 1 || strlen($_POST['headline']) < 1
  || strlen($_POST['summary']) < 1 ) {
    $_SESSION['error'] = 'All fields are required';
    header("Location: edit.php?profile_id=".$_GET['profile_id']);
    return; }

    if ( strpos($_POST['email'],'@') === false ) {
      $_SESSION['error'] = 'Valid email contains an "@" signs';
      header("Location: edit.php?profile_id=".$_GET['profile_id']);
      return;
    }

    $sql = "UPDATE profile SET first_name = :fn,
    last_name = :las, email = :em, headline = :hl, summary = :sm
    WHERE profile_id = :profile_id";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(array(
      ':fn' => $_POST['first_name'],
      ':las' => $_POST['last_name'],
      ':em' => $_POST['email'],
      ':hl' => $_POST['headline'],
      ':sm' => $_POST['summary'],
      ':profile_id' => $_POST['profile_id']) ) ;
      $_SESSION['success'] = 'Record updated';
      header( 'Location: index.php' ) ;
      return; }




### load data from db for HTML Form in view
$stmt = $pdo->prepare("SELECT * FROM profile where profile_id = :xyz");
$stmt->execute(array(":xyz" => $_GET['profile_id']));
$row = $stmt->fetch(PDO::FETCH_ASSOC);
if ( $row === false ) {
  $_SESSION['error'] = 'Bad value for profile_id';
  header( 'Location: index.php' ) ;
  return;
}

$fn = htmlentities($row['first_name']);
$ln = htmlentities($row['last_name']);
$em = htmlentities($row['email']);
$hl = htmlentities($row['headline']);
$sm = htmlentities($row['summary']);
$profile_id = $row['profile_id'];

?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>46ab5450</title>
  </head>
  <body>
    <h1><?php echo "Editing Profile for: ";
          echo htmlentities($_SESSION['name']); ?></h1>
    <p> <?php flash();

     ?> </p>
    <form method="post">
      <p><label for="first_name">First Name: </label>
      <input type="text" name="first_name" value="<?= $fn ?>"></p>
      <p><label for="last_name">Last Name: </label>
      <input type="text" name="last_name" value="<?= $ln ?>"></p>
      <p><label for="email">Email: </label>
      <input type="text" name="email" value="<?= $em ?>"></p>
      <p><label for="headline">Headline: </label></p>
      <p><input type="text" name="headline" size="80" value="<?= $hl ?>"></p>
      <p><label for="summary">Summary: </label></p>
      <textarea name="summary" rows="8" cols="80"><?= $sm ?></textarea>
      <input type="hidden" name="profile_id" value="<?= $profile_id ?>">
      <p><input type="submit" value="Save">
      <input type="submit" name="cancel" value="Cancel"></p>
    </form>
  </body>
</html>
