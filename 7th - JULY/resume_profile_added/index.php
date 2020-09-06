<?php
session_start();
require_once "pdo.php";
require_once "function.php";


 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>46ab5450</title>
  </head>
  <body>
    <h1>index.php</h1>
    <?php
      flash();

      # if not logged in
      if (! isset($_SESSION["name"]) && ! isset($_SESSION["user_id"])) {
        notLoggedIn();
         }

      if (isset($_SESSION["name"]) && isset($_SESSION["user_id"])) {
        loggedIn();
        }

        ?>
  </body>
</html>
