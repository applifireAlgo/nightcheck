




echo $PATH
DB_PATH=/tmp/applifire/db/IMSF5AYGXFDOMEIGQWM7Q/76C401BF-3A75-405B-82CD-BA60F5EB8A58
MYSQL=/usr/bin
USER=project1
PASSWORD=project1
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'