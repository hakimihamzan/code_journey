<?php // Do not put any HTML above this line

if ( isset($_POST['cancel'] ) ) {
    // Redirect the browser to login page
    header('Location: index.php');
    return;
}

$salt = 'XyZzy12*_';
$stored_hash = '1a52e17fa899cf40fb04cfc42e6352f1';  // Pw is php123

$failure = false;  // If we have no POST data

// Check to see if we have some POST data, if we do process it
if ( isset($_POST['who']) && isset($_POST['pass']) ) {
    if ( strlen($_POST['who']) < 1 || strlen($_POST['pass']) < 1) {
        $failure = "Email and password are required";
    } else {
        // check email sign valid
        $a = $_POST['who'];
        $b = strpos($a, "@");
        if ($b == false) {
              $failure = 'Valid email contains an "@" signs';
        } else {
              $check = hash('md5', $salt.$_POST['pass']);
              if ( $check == $stored_hash ) {
                  // Redirect the browser to game.php
                  header("Location: autos.php?name=".urlencode($_POST['who']));
                  error_log("Login success ".$_POST['who']);
                  return;
              } else {
                  $failure = "Incorrect password";
                  error_log("Login fail ".$_POST['who']." $check");
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
    <h1>Log In Page</h1>
    <form method="POST">
    <?php
      if ( $failure !== false ) {
          echo('<p style="color: red;">'.htmlentities($failure)."</p>\n");
      }
      ?>
    <label for="nam">Email </label>
    <p><input type="text" name="who" id="nam"></p>
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
