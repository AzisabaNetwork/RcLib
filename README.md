<p align="center"><img src="images/rclib.png" width="64px" height="64px"></p>

<h1 align="center">RcLib</h1>

<p align="center">ReinCarnationのPL開発を支援するライブラリ</p>

## 概要

* RcLibは、ReinCarnationの開発を支援するライブラリです。
* ReinCarnation向けである為、MC 1.17.1向けに開発されています。
* バージョン更新により、共通化したいまたは頻繁に使用する機能を追加します。

## ドキュメント

(1) インポート

1. リポジトリよりライブラリ本体(jar)をダウンロードし、コンピュータ内のお好みの位置に保存します。
2. プラグインプロジェクトの、pom.xmlに以下の記述を追加してください。
    ```XML
    <dependency>
        <groupId>net.azisaba</groupId>
        <artifactId>rclib</artifactId>
        <version>1.0.0</version>
        <scope>system</scope>
        <systemPath>ライブラリ本体のパス</systemPath>
    </dependency>
    ```
3. Mavenを再読み込みしてください。

(2) utils.DataBase

* データベースの操作を簡略化します。
* DBサーバーとの接続はメソッド呼び出し毎に実行され、close()を使用するまで維持されます。
* `DataBase db = new DataBase(URL, USER, PASS);`を使用してインスタンスを作成します。
* `db.executeUpdate(sql);`を使用してexecuteUpdateでSQL文を実行します。
* `db.executeQuery(sql);`を使用してexecuteQueryでSQL文を実行します。戻り値にResuleSetが与えられます。
* `db.preparedStatement(sql);`を使用してpreparedStatementでSQL文を実行します。戻り値にPreparedStatementが与えられます。
* `db.close();`を使用してリソースを解放します。必要な処理を行った後には必ず実行するようにしてください。

(3) utils.Message

* メッセージの装飾の統一を簡単にし、「痒い所に手が届く送信方法」を利用できます。
* Example>>だったりExample:だったり、形式を統一して視認性を向上させます。
* `プラグイン名: メッセージ`で統一されます。プラグイン名の色は、一文字のアルファベットによって自動的に決定されます。
* `Message.generate(plugin, message);`を使用して統一された形でメッセージを生成します。String型で戻り値が与えられます。
* `Message.send(plugin, message);`を使用してメッセージをサーバーにbroadcastします。
* `Message.sendPlayer(player, plugin, message);`を使用して引数のプレイヤーにメッセージを送信します。
* `Message.sendConsole(plugin, message);`を使用してコンソールにログとして送信します。
* `Message.sendCommandSender(sender, plugin, message);`を使用してコマンド送信者にメッセージを送信します。
* `Message.sendPermission(permission, plugin, message);`を使用して引数の権限を持っているプレイヤーに限定してメッセージを送信します。
* `Message.sendScoreboardTag(scoreboardTag, plugin, message);`を使用して引数のスコアボードタグを持っているプレイヤーに限定してメッセージを送信します。

(4) utils.Yaml

* カスタムコンフィグの実装を簡略化します。
* `Yaml yaml = new Yaml(yamlId);`を使用してインスタンスを作成します。yamlIdには、サーバーのpluginsフォルダからの相対パスを指定します。
* `yaml.get();`を使用してYamlConfigurationオブジェクトを生成し、戻り値として与えられます。
* `yaml.set(yamlConfig)`を使用してファイルをyamConfigurationで上書きします。
* yamlConfigurationは、取得時の状態のまま更新された値を参照しない為、以下のように使用します。
    ```Java
    Yaml yaml = new Yaml(Hello/world.yml);
    // 値を取得する
    String str = yaml.get().getString("owner");
    // 値を設定する
    YamlConfiguration yamlConfig = yaml.get();
    yamlConfig.set("owner", "takumi3s");
    yaml.set(yamlConfig);
    ```

(5) entitys.user

* プレイヤーに紐付けされたオブジェクト(User)の持つデータを操作します。
* `User user = new User(userId);`を使用してインスタンスを作成します。userIdにはuuidを指定します。
* `user.getUserId();`を使用してuserIdを取得します。
* `user.getName();`を使用してnameを取得します。
* `user.setName(name)`を使用してnameを設定します。
* `user.getMoney();`を使用してmoneyを取得します。
* `user.setMoney(money)`を使用してmoneyを設定します。

## ライセンス

* ©azisaba