
select owner from playlists
inner join playlistsongs on playlists.id = playlistsongs.playlistId
inner join songs on songs.id = playlistsongs.songId
where songs.title = 'Extreme Action';