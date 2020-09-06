<?php
session_start();
require_once "pdo.php";
require_once 'function.php';

// check if logged in or not
if ( ! isset($_SESSION["name"]) ) {
  die("<b>ACCESS DENIED!</b>");
  return;
}

// If the user requested logout go back to index.php
if ( isset($_POST['cancel']) ) {
    header('Location: index.php');
    return;
}

### adding data
if (isset($_POST['first_name']) && isset($_POST['last_name'])
  && isset($_POST['email'])  && isset($_POST['headline'])
  && isset($_POST['summary']))
  {
    if ( strlen($_POST['first_name']) < 1 || strlen($_POST['last_name']) < 1
    || strlen($_POST['email']) < 1 || strlen($_POST['headline']) < 1
    || strlen($_POST['summary']) < 1 ) {
      $_SESSION['error'] = 'All fields are required';
      header("Location: add.php");
      return; }

    if ( strpos($_POST['email'],'@') === false ) {
      $_SESSION['error'] = 'Valid email contains an "@" signs';
      header("Location: add.php");
      return;
    }

    $stmt = $pdo->prepare('INSERT INTO Profile
  (user_id, first_name, last_name, email, headline, summary)
  VALUES ( :uid, :fn, :ln, :em, :he, :su)');
    $stmt->execute(array(
      ':uid' => $_SESSION['user_id'],
      ':fn' => $_POST['first_name'],
      ':ln' => $_POST['last_name'],
      ':em' => $_POST['email'],
      ':he' => $_POST['headline'],
      ':su' => $_POST['summary']) );
      $_SESSION["success"] = "added";
      header( 'Location: index.php' ) ;
      return;
}


 ?>

 <!DOCTYPE html>
 <html lang="en" dir="ltr">
   <head>
     <meta charset="utf-8">
     <title>46ab5450</title>
   </head>
   <body>
     <div class="container">
       <h1> <?php echo "Adding Profile for: ";
       echo htmlentities($_SESSION['name']); ?> </h1>

      <p> <?php flash(); ?> </p>

      <form method="post">
        <p><label for="first_name">First Name: </label>
        <input type="text" name="first_name"></p>
        <p><label for="last_name">Last Name: </label>
        <input type="text" name="last_name"></p>
        <p><label for="email">Email: </label>
        <input type="text" name="email"></p>
        <p><label for="headline">Headline: </label></p>
        <p><input type="text" name="headline" size="80"></p>
        <p><label for="summary">Summary: </label></p>
        <textarea name="summary" rows="8" cols="80"></textarea>
        <p><input type="submit" value="Add">
        <input type="submit" name="cancel" value="Cancel"></p>
      </form>
     </div>

   </body>
 </html>
