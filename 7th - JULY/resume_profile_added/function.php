<?php

function notLoggedIn(){
  global $pdo;
  $stmt = $pdo->query("SELECT profile_id, first_name, last_name, email,
    headline, summary FROM profile");

  if ($stmt->rowCount() < 1) {
          echo '<p><a href="login.php">Please log in</a></p>';

  } else {
          echo('<p><a href="login.php">Please log in</a></p>');
          echo('<table border="1">'."\n");
          echo "<tr><th> Name </th><th> Headline </th></tr>";
          while ( $row = $stmt->fetch(PDO::FETCH_ASSOC) ) {
              $kimi = htmlentities($row['first_name'])." ".htmlentities($row['last_name']);
              echo "<tr><td>";
              echo('<a href="view.php?profile_id='.$row['profile_id'].'">');
              echo($kimi);
              echo('</a>');
              echo("</td><td>");
              echo(htmlentities($row['headline']) );
              echo("</td></tr>\n");  } }
}

function loggedIn() {
  global $pdo;
  $stmt = $pdo->query("SELECT profile_id, first_name, last_name, email,
    headline, summary FROM profile");

  if ($stmt->rowCount() < 1) {
          echo "<a href='logout.php'>Logout</a><br></p>";
          echo "<p>No data available</p>";
          echo "<p><a href='add.php'>Add New Entry</a><br>";

  } else {
          echo "<p><a href='logout.php'>Logout</a><br></p>";
          echo('<table border="1">'."\n");
          echo "<p><tr><th>Name</th><th>Headline</th><th>Action</th></tr>";
          while ( $row = $stmt->fetch(PDO::FETCH_ASSOC) ) {
            $kimi = htmlentities($row['first_name'])." ".htmlentities($row['last_name']);
            echo "<tr><td>";
            echo('<a href="view.php?profile_id='.$row['profile_id'].'">');
            echo($kimi);
            echo('</a>');
            echo("</td><td>");
            echo(htmlentities($row['headline']));
            echo("</td><td>");
            echo('<a href="edit.php?profile_id='.$row['profile_id'].'">Edit</a> / ');
            echo('<a href="delete.php?profile_id='.$row['profile_id'].'">Delete</a>');
            echo("</td></tr>\n");
          }
          echo "</table></p>";
          echo "<a href='add.php'>Add New Entry</a>"; } }



  function viewMe() {
    global $pdo;
    $stmt = $pdo->prepare("SELECT first_name, last_name, email, headline, summary, profile_id FROM profile where profile_id = :xyz");
    $stmt->execute(array(":xyz" => $_GET['profile_id']));
    $row = $stmt->fetch(PDO::FETCH_ASSOC);

    echo "<p>First name : ";
    echo(htmlentities($row['first_name']));
    echo "</p>";
    echo "<p>Last name : ";
    echo(htmlentities($row['last_name']));
    echo "</p>";
    echo "<p>Email : ";
    echo(htmlentities($row['email']));
    echo "</p>";
    echo "<p>Headline : </p>";
    echo "<p>";
    echo(htmlentities($row['headline']));
    echo "</p>";
    echo "<p>Summary : </p>";
    echo "<p>";
    echo(htmlentities($row['summary']));
    echo "</p><br>";
    echo('<a href="index.php">');
    echo("Done</a>");
  }


  function flash(){
    if ( isset($_SESSION["error"]) ) {
        echo('<p style="color:red">'.$_SESSION["error"]."</p>\n");
        unset($_SESSION["error"]);
    }
    if ( isset($_SESSION["success"]) ) {
        echo('<p style="color:green">'.$_SESSION["success"]."</p>\n");
        unset($_SESSION["success"]);
    }    
  }
