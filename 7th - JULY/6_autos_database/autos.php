<?php
require_once "pdo.php";
// Demand a GET parameter
if ( ! isset($_GET['name']) || strlen($_GET['name']) < 1  ) {
    die('Name parameter missing. Please log in');
}
// If the user requested logout go back to index.php
if ( isset($_POST['logout']) ) {
    header('Location: index.php');
    return;
}
########################################################################
$failure = false;
$success = false;

if (isset($_POST['make']) && isset($_POST['year'])
      && isset($_POST['mileage']) ) {

          if ( strlen($_POST['make']) < 1 ) {
              $failure = "Make is required!";

          } else {
              if (is_numeric($_POST['year']) == False || is_numeric($_POST['mileage']) == False) {
                  $failure = "Mileage and year must be numeric";
              } else {
                  $stmt = $pdo->prepare('INSERT INTO autos (make, year, mileage)
                                      VALUES ( :mk, :yr, :mi)');
                  $stmt->execute(array(
                        ':mk' => $_POST['make'],
                        ':yr' => $_POST['year'],
                        ':mi' => $_POST['mileage']) ) ;
                  $success = "Record inserted!";
              }
          }
      }
########################################################################

if ( isset($_POST['delete']) && isset($_POST['auto_id']) ) {
    $sql = "DELETE FROM autos WHERE auto_id = :zip";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(array(':zip' => $_POST['auto_id']));
}
###########################################################################
$stmt = $pdo->query("SELECT make, year, mileage, auto_id FROM autos");
$rows = $stmt->fetchAll(PDO::FETCH_ASSOC);
############################################################################
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
      <h1><?php if ( isset($_REQUEST['name']) ) {
            echo "Tracking Autos for: ";
            echo htmlentities($_REQUEST['name']);
            echo "</p>\n";} ?>
      </h1>
      <form method="post">
        <p>
          <?php
            if ( $failure !== false ) {
                echo('<p style="color: red;">'.htmlentities($failure)."</p>\n");
            }
             if ( $success !== false ) {
                echo('<p style="color: green;">'.htmlentities($success)." </p>\n");
              }

            ?>
        </p>
        <label for="make">Make</label>
        <p><input type="text" name="make"></p>
        <label for="year">Year</label>
        <p><input type="text" name="year" id="year"></p>
        <label for="mileage">Mileage</label>
        <p><input type="text" name="mileage" id="mmileage"></p>
        <input type="submit" value="Add">
        <input type="submit" name="logout" value="Logout">
      </form>


      <h1>Automobiles</h1>
      <table border="2">
        <?php
        foreach ( $rows as $row ) {
            echo "<tr><td>";
            echo(htmlentities($row['auto_id']));
            echo("</td><td>");
            echo(htmlentities($row['make']));
            echo("</td><td>");
            echo(htmlentities($row['year']));
            echo("</td><td>");
            echo(htmlentities($row['mileage']));
            echo("</td><td>");
            echo('<form method="post"><input type="hidden" ');
            echo('name="auto_id" value="'.$row['auto_id'].'">'."\n");
            echo('<input type="submit" value="Del" name="delete">');
            echo("\n</form>\n");
            echo("</td></tr>\n");
          }
        ?>
        </table>
    </div>
  </body>
</html>
