




echo $PATH
DB_PATH=/tmp/applifire/db/DMIRU0SUARNWZGPDRWFJAW/61B95991-97C3-4D61-A0CD-9EE7DF872F51
MYSQL=/usr/bin
USER=project21
PASSWORD=project21
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'