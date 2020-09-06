<?php

require_once "pdo.php";
session_start();
// check if logged in or not
if ( ! isset($_SESSION["email"]) ) {
  echo "<b>ACCESS DENIED!</b>";
  return;
}

// If the user requested logout go back to index.php
if ( isset($_POST['cancel']) ) {
    header('Location: index.php');
    return;
}

################################################################


if (isset($_POST['make']) && isset($_POST['year'])
      && isset($_POST['mileage']) && isset($_POST['model'])) {

          if ( strlen($_POST['make']) < 1 ) {
              $_SESSION["error2"] = "All values are required";
              header( 'Location: add.php' ) ;
              return;

          } else {
              if (is_numeric($_POST['year']) == False || is_numeric($_POST['mileage']) == False) {
                  $_SESSION["error2"]  = "Mileage and year must be numeric";
                  header( 'Location: add.php' ) ;
                  return;
              } else {
                  $stmt = $pdo->prepare('INSERT INTO autos (make, year, mileage, model)
                                      VALUES ( :mk, :yr, :mi, :mo)');
                  $stmt->execute(array(
                        ':mk' => $_POST['make'],
                        ':yr' => $_POST['year'],
                        ':mi' => $_POST['mileage'],
                        ':mo' => $_POST['model'] ) ) ;
                  $_SESSION["success"] = "added";
                  header( 'Location: index.php' ) ;
                  return;
              }
          }
      }
#############################################################

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
       <h1><?php if ( isset($_SESSION['email']) ) {
             echo "Tracking Autos for: ";
             echo htmlentities($_SESSION['email']);
             echo "</p>\n";}
             ?>
       </h1>

      <p>  <?php
      if (isset($_SESSION["error2"])) {
        echo('<p style="color:red">'.$_SESSION["error2"]."</p>\n");
        unset($_SESSION["error2"]);
      }

       ?> </p>

       <form method="post">
         <label for="make">Make</label>
         <p><input type="text" name="make"></p>
         <label for="model">Model</label>
         <p><input type="text" name="model"></p>
         <label for="year">Year</label>
         <p><input type="text" name="year"></p>
         <label for="mileage">Mileage</label>
         <p><input type="text" name="mileage"></p>
         <input type="submit" value="Add">
         <input type="submit" name="cancel" value="Cancel">
       </form>
     </div>

   </body>
 </html>
