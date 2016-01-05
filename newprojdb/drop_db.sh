




echo $PATH
DB_PATH=/tmp/applifire/db/4CNGHW6ARO2U3CLFU0E9DW/2210B5FB-84A2-4AFC-8104-FA9522417D5F
MYSQL=/usr/bin
USER=newproj
PASSWORD=newproj
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'