
<?php

include "conf.php";

$reponse = $bdd->query('SELECT * FROM Entreprise');
while ($donnees = $reponse->fetch())
{

echo 'Nom de l_entreprise : '.$donnees['nomEntreprise'].'</br>';

}



