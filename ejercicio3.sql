
select albums.title from albums
where albums.artist = (select artist from songs
where plays = (select max(plays)  maximo from songs))
