$book = [System.IO.File]::ReadAllBytes("C:\Users\MavaddatJavid\Calibre Portable\Calibre Library\Quentin Charatan\Java in Two Semesters_ Featuring Ja (148)\Java in Two Semesters_ Featurin - Quentin Charatan.epub")
[System.Reflection.Assembly]::LoadWithPartialName('System.IO.Compression');  $zipStream = New-Object System.IO.Memorystream;   $zipStream.Write($book,0,$book.Count)
$zipFile = [System.IO.Compression.ZipArchive]::new($zipStream)
$xhtmlFiles = $zipFile.Entries | Where-Object -Property FullName -Match "En_\d.*xhtml"
foreach($xhtmlFile in $xhtmlFiles){
    $chapter  = $zipFile.GetEntry($xhtmlFile) 
    $chapter.Open().Read(($chContentBytes = [byte[]]::new($chapter.Length)),0,$($chapter.Length))
    $chContentStr = [System.Text.Encoding]::Default.GetString($chContentBytes)
}
