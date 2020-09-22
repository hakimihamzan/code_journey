<?php
#####################   check if there a session from before
require_once "pdo.php";
session_start();

if ( isset($_SESSION["email"]) ) {
  $stmt = $pdo->query("SELECT make, year, mileage, auto_id FROM autos");
  $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
#################################
# check if we are logged in
if ( ! isset($_SESSION["email"]) ) {
  echo "Not logged in";
  return;
}

####################################


// If the user requested logout go back to index.php
if ( isset($_POST['logout']) ) {
    header('Location: logout.php');
    return;
}
################################

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
      <p><?php if (  isset($_SESSION["insert"]) ) {
            echo('<p style="color:green">'.$_SESSION["insert"]."</p>\n");
            unset($_SESSION["insert"]); }
            ?>
      </p><br>

      <h3>Automobiles</h3>
      <table border="2">
        <?php
            echo "<tr><th>";
            echo "Make";
            echo "</th><th>";
            echo "Year";
            echo "</th><th>";
            echo "Mileage";
            echo "</th></tr>";

        foreach ( $rows as $row ) {
            echo "<tr><td>";
            echo(htmlentities($row['make']));
            echo("</td><td>");
            echo(htmlentities($row['year']));
            echo("</td><td>");
            echo(htmlentities($row['mileage']));
            echo("</td></tr>\n");
          }
        ?>
      </table><br>
        <p>
          <a href="add.php">Add New</a> | <a href="logout.php">Logout</a>
        </p>
      </div>
  </body>
</html>
