# 點歌+歌詞查詢程式
## 實作功能
* 使用Intent在activity間轉換
* 透明化設計Button元件及按下特效
* 模糊背景
* 歌詞圖片使用透明png
* 可捲動的layout

## 程式截圖與說明

* 程式初始畫面

C可清除所有TextView中的內容
DELETE則是退後一格

<img src="https://github.com/miyuiki/SimpleMusicPlayer/blob/master/screenshot/Screenshot_1493481640.png?raw=true" width = "360" height = "640" align=center />

按下LIST可顯示可點播的歌曲清單，按下ENTER則會跳至另一個activity並顯示相對應歌詞

<img src="https://raw.githubusercontent.com/miyuiki/SimpleMusicPlayer/master/screenshot/Screenshot_1493481654.png" width = "360" height = "640" align=center />

號碼輸入畫面

<img src="https://raw.githubusercontent.com/miyuiki/SimpleMusicPlayer/master/screenshot/Screenshot_1493481659.png" width = "360" height = "640" align=center />

若不是輸入1~5則會跳出警告訊息

<img src="https://github.com/miyuiki/SimpleMusicPlayer/blob/master/screenshot/Screenshot_1493481671.png?raw=true" width = "360" height = "640" align=center />

* 歌詞頁面
按下ENTER後跳至歌詞頁面

<img src="https://github.com/miyuiki/SimpleMusicPlayer/blob/master/screenshot/Screenshot_1493481701.png?raw=true" width = "360" height = "640" align=center />

按下下一曲或上一曲皆可換歌

<img src="https://raw.githubusercontent.com/miyuiki/SimpleMusicPlayer/master/screenshot/Screenshot_1493481718.png" width = "360" height = "640" align=center />

<img src="https://raw.githubusercontent.com/miyuiki/SimpleMusicPlayer/master/screenshot/Screenshot_1493481725.png" width = "360" height = "640" align=center />

按下HOME則會關閉此activity跳回輸入號碼的畫面
另外COVER和LYRICS按鈕尚未實作，目前沒有功能><
