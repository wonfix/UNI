# UNI
Cosas Universidad

1.Clonar Repositorio
git clone https://github.com/wonfix/UNI.git

2.Ver el estado del repo
git status

3.Realizar cambios y hacer commits
Si tienes muchos cambios y quieres subir todos utiliza
git add .
Si solo quieres subir los cambios de algo especifico utiliza
git add NombreFichero
Para guardar los cambios en el historial de git
git commit -m "mensaje descriptivo"

4.Subir cambios al repositorio remoto
git push origin main(rama que sea)

6.Obtener cambios desde el repo remoto
git pull origin main(rama que sea)

7.Ver los repo remoto asociados
git remote -v

8.Eliminar el repositorio local
rm -rf UNI


9. Para crear una nueva rama:
git checkout rama "cuando creamos una rama nueva a partir de una nueva tendremos que asegurarnos que estamos en la rama que queremos"CLONAR""
git pull origin rama "Para asegurarnos que la rama que quermos "Clonar" esta con los cambios actuales"
git checkout -b Nueva-Rama "Para crear la nueva Rama"
git branch "Para ver cuanta rama tenemos y saldra como * en la que estamos"
git push -u origin Nueva-Rama "Una vez creada la rama en local hay que subirla a gitHub"
el -u hace un git push y git pull
git checkout rama "Cambiara de rama a la que quieras"

