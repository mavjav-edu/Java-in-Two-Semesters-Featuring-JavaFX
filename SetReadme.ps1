#Requires -PSEdition Core
$TESTING = $true

$book = [System.IO.File]::ReadAllBytes("C:\Users\MavaddatJavid\Calibre Portable\Calibre Library\Quentin Charatan\Java in Two Semesters_ Featuring Ja (148)\Java in Two Semesters_ Featurin - Quentin Charatan.epub")
$chFileNamePattern = [regex]::new("\d+_\d_En_(\d+)_Chapter\.xhtml")
[System.Reflection.Assembly]::LoadWithPartialName('System.IO.Compression')
$zipStream = New-Object System.IO.Memorystream
$zipStream.Write($book, 0, $book.Count) | Out-Null
$zipFile = [System.IO.Compression.ZipArchive]::new($zipStream)
$htmlFiles = $zipFile.Entries | Where-Object -Property FullName -Match $chFileNamePattern
foreach ($htmlFile in $htmlFiles) {
    $chapter = $zipFile.GetEntry($htmlFile)
    $chapter.Open().Read(($chContentBytes = [byte[]]::new($chapter.Length)), 0, $($chapter.Length)) | Out-Null
    $chContentStr = [System.Text.Encoding]::Default.GetString($chContentBytes)
    $HTML = New-Object -Com "HTMLFile"
    $HTML.write([ref]$chContentStr) | Out-Null
    $chNum = [int](Select-String -InputObject $htmlFile.Name -Pattern $chFileNamePattern).Matches.Groups[1].Value
    $chPath = (Resolve-Path "chapter$chNum*" -Relative)  -replace '^\.\\',''
    $README_md = Join-Path $chPath 'README.md'
    # $chTitle has XPath //section[@class='selfTestQuestions'][1]
    $chTitle = $HTML.getElementsByClassName("ChapterTitle")[0].innerHTML -replace "\d+\.&.*;",''
    $selfTests = $HTML.getElementsByClassName('selfTestQuestions')
    $exercises = $HTML.getElementsByClassName('programmingExercises')
    $i = 0
    $outStr = Out-String -InputObject ("<H1>" + $chTitle + "</H1>`n" | pandoc @("--from=HTML", "--to=markdown_mmd+backtick_code_blocks+fenced_code_blocks+autolink_bare_uris"))
    $outStr = @"
---
layout: default
title: $chTitle
---

$outStr

"@

    if ($TESTING) {
        $tempFile = New-TemporaryFile
        Out-File -InputObject $outStr -FilePath  $tempFile -Encoding utf8
        if ( Test-Path $README_md ) {
            Get-Content $README_md | Out-File -FilePath $tempFile -Append
        }
        Move-Item -Path $tempFile -Destination $README_md -Force
    }
    else {
        Out-File -InputObject $outStr -FilePath  $README_md -Append -Encoding utf8
    }
    foreach ($selfTest in $selfTests) {
        $i++
        $outStr = Out-String -InputObject (("<BR/>" + (Out-String -InputObject $selfTest.innerHTML) -creplace '<span class="HeadingNumber">[\d\.]+</span>', "" | pandoc @("--from=HTML", "--to=markdown_mmd+backtick_code_blocks+fenced_code_blocks+autolink_bare_uris")) -replace $chFileNamePattern, '../chapter_$1/README.md')

        if($TESTING){
            Out-Host -InputObject $outStr
            pause
        } else{
            Out-File -InputObject $outStr -FilePath  $README_md -Append -Encoding utf8
        }
    }
    foreach ($exercise in $exercises) {
        $i++
        $outStr = Out-String -InputObject (("<BR/>" + (Out-String -InputObject $exercise.innerHTML) -creplace '<span class="HeadingNumber">[\d\.]+</span>', "" | pandoc @("--from=HTML", "--to=markdown_mmd+backtick_code_blocks+fenced_code_blocks+autolink_bare_uris")) -replace $chFileNamePattern, '../chapter_$1/README.md')

        if($TESTING){
            Out-Host -InputObject $outStr
            pause
        } else{
            Out-File -InputObject $outStr -FilePath  $README_md -Append -Encoding utf8
        }
    }
}