
select distinct albums.title from albums
inner join songs on songs.albumOrder = albums.id
where duration < 5;