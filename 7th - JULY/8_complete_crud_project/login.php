<?php // Do not put any HTML above this line

session_start();
if ( isset($_POST['cancel'] ) ) {
    // Redirect the browser to login page
    header('Location: logout.php');
    return;
}

if ( isset($_POST["email"]) && isset($_POST["pass"]) ) {
    unset($_SESSION["email"]);
    $salt = 'XyZzy12*_';
    $stored_hash = '1a52e17fa899cf40fb04cfc42e6352f1';  // Pw is php123
    $failure = false;  // If we have no POST data

    // Check to see if we have some POST data, if we do process it
    if ( strlen($_POST['email']) < 1 || strlen($_POST['pass']) < 1) {
            $_SESSION["error"] = "Email and password are required";
            header( 'Location: login.php' ) ;
            return;
    } else {
            // check email sign valid
            $a = $_POST['email'];
            $b = strpos($a, "@");
            if ($b == false) {
                    $_SESSION["error"] = 'Valid email contains an "@" signs';
                    header( 'Location: login.php' ) ;
                    return;
            } else {
                  $check = hash('md5', $salt.$_POST['pass']);
                  if ( $check == $stored_hash ) {
                      // Redirect the browser to game.php
                      $_SESSION["email"] = $_POST["email"];
                      header( 'Location: index.php' ) ;
                      error_log("Login success ".$_POST['email']);
                      return;
                  } else {
                      $_SESSION["error"] = "Incorrect password";
                      header( 'Location: login.php' ) ;
                      error_log("Login fail ".$_POST['email']." $check");
                      return;
                  }
            }
        }
}



// Fall through into the View
?>

<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
    integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <title>MUHAMAD HAKIMI BIN HAMZAN</title>
  </head>
  <body>
    <div class="container">
    <h1>Please Log In</h1>
    <p> <?php
    if ( isset($_SESSION["error"]) ) {
        echo('<p style="color:red">'.$_SESSION["error"]."</p>\n");
        unset($_SESSION["error"]);
    }
      ?></p>
    <form method="POST">
    <label for="nam">Email </label>
    <p><input type="text" name="email" id="nam"></p>
    <label for="id_1723">Password </label>
    <p><input type="text" name="pass" id="id_1723"></p>

    <input type="submit" value="Log In">
    <input type="submit" name="cancel" value="Cancel">
    </form>
    <p><i>Check html source for Password's hint</i></p><br>
    <p>Hit to <a href="<?php echo($_SERVER['PHP_SELF']);?>">refresh</a> login page</p>

<!-- Password is 3 letter abbreviation for the application that
     we are learning followed by 123 -->



    <div >
  </body>
</html>
