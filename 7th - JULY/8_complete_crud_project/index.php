<?php
#####################   check if there a session from before
session_start();
####################################
// If the user requested logout go back to index.php

########################################### this is function for table

function table() {

require_once "pdo.php";
$stmt = $pdo->query("SELECT make, model, year, mileage, auto_id FROM autos");

if ($stmt->rowCount() < 1) {
        echo "No rows found";
        echo "<p><a href='add.php'>Add New Entry</a><br>";
        echo "<a href='logout.php'>Logout</a><br></p>";

} else {
        echo('<table border="1">'."\n");
        echo "<tr><th> Make </th><th> Model </th><th> Year </th><th>";
        echo " Mileage </th><th> Action </th></tr>";
        while ( $row = $stmt->fetch(PDO::FETCH_ASSOC) ) {
            echo "<tr><td>";
            echo(htmlentities($row['make']));
            echo("</td><td>");
            echo(htmlentities($row['model']));
            echo("</td><td>");
            echo(htmlentities($row['year']));
            echo("</td><td>");
            echo(htmlentities($row['mileage']));
            echo("</td><td>");
            echo('<a href="edit.php?auto_id='.$row['auto_id'].'">Edit</a> / ');
            echo('<a href="delete.php?auto_id='.$row['auto_id'].'">Delete</a>');
            echo("</td></tr>\n");
          }
          echo "</table>";
          echo "<p><a href='add.php'>Add New Entry</a><br>";
          echo "<a href='logout.php'>Logout</a><br></p>";
          }
    }
##############################################
 ?>
<html>
<header>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
    integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <title>MUHAMAD HAKIMI BIN HAMZAN</title>
</header>

<body>
    <div class="container">
      <h1>Welcome to Autos Database</h1>

      <p><?php

      if (! isset($_SESSION['email']) ) {
          echo "<p><a href='login.php'>Please log in</a> to access our database</p>";
          echo "<p>Attempt to <a href='add.php'>add</a> data without logging in.</p>";
      } else {
        if ( isset($_SESSION['success']) ) {
            echo '<p style="color:green">'.$_SESSION['success']."</p>\n";
            unset($_SESSION['success']); }
          table();
      }
    ?></p>
    </div>
</body>

</html>
