<p align="center"><img src="images/rclib.png" width="64px" height="64px"></p>

<h1 align="center">RcLib</h1>

<p align="center">ReinCarnationのPL開発を支援するライブラリ</p>

## 概要

* RcLibは、ReinCarnationの開発を支援するライブラリです。
* ReinCarnation開発向けである為、MC 1.17.1向けに開発されています。
* バージョン更新により、共通化したいまたは頻繁に使用する機能を追加します。
* オープンソースで公開されており、改造し別の環境向けに最適化してRcLibのライセンスのもと使用することができます

## ドキュメント

(1) インポート

1. リポジトリよりライブラリ本体(jar)をダウンロードし、コンピュータ内のお好みの位置に保存します。
2. プラグインプロジェクトの、pom.xmlに以下の記述を追加してください。
    ```XML
    <dependency>
        <groupId>net.azisaba</groupId>
        <artifactId>rclib</artifactId>
        <version>バージョン</version>
        <scope>system</scope>
        <systemPath>ライブラリ本体のパス(※「/」ではなく「\」区切り)</systemPath>
    </dependency>
    ```
3. plugin.ymlに以下の記述を追加してください。
    ```Yaml
    depend: [RcLib]
    ```
4. Mavenを再読み込みしてください。

(2) entitys.User

* プレイヤーに紐付けされたオブジェクト(User)の持つデータを操作します。
* `User user = new User(userId);`を使用してインスタンスを作成します。userIdにはuuidを指定します。
* `user.getUserId();`を使用してuserIdを取得します。
* `user.getName();`を使用してnameを取得します。
* `user.setName(name);`を使用してnameを設定します。
* `user.getMoney();`を使用してmoneyを取得します。
* `user.setMoney(money);`を使用してmoneyを設定します。

(3) utils.CraftMath

* 計算に関する処理を補助します。(Java標準のMathクラスの補助的な位置付けです。)
* `CraftMath.isInt(target);`でStringまたはcharを指定することで整数であるか(int型に変換できるか)を戻り値で取得します。
* ※ このクラスは開発中であり、削除される又は仕様が大幅に変更される可能性のあるものです。

(3) utils.CraftPlayer

* プレイヤーに関する処理を補助します。
* `CraftPlayer.isOnline();`を使用してプレイヤーがオンラインかを判定します。
* `CraftPlayer.getHead();`を使用してHeadを取得します。(※ 1.3.0でutils.Headから移動)

(4) utils.DataBase

* データベースの操作を簡略化します。
* DBサーバーとの接続はメソッド呼び出し毎に実行され、close()を使用するまで維持されます。
* `DataBase db = new DataBase(URL, USER, PASS);`を使用してインスタンスを作成します。
* `db.executeUpdate(sql);`を使用してexecuteUpdateでSQLを実行します。
* `db.executeQuery(sql);`を使用してexecuteQueryでSQLを実行します。戻り値にResuleSetが与えられます。
* `db.preparedStatement(sql);`を使用してpreparedStatementでSQLを実行します。戻り値にPreparedStatementが与えられます。
* `db.close();`を使用してリソースを解放します。必要な処理を行った後には必ず実行するようにしてください。

(5) utils.Log

* ログファイルの実装を簡略化します。
* `Log log = new Log("fileName");`を使用してインスタンスを作成します。
* `log.w("...");`を使用してログを書き込みます。時刻は自動で記述されます。

(6) utils.Yaml

* カスタムコンフィグの実装を簡略化します。
* `Yaml yaml = new Yaml(yamlId);`を使用してインスタンスを作成します。yamlIdには、拡張子を除いたファイル名、pluginにはJavaPluginオブジェクトを指定します。
* `yaml.get();`を使用してYamlConfigurationオブジェクトを生成し、戻り値として与えられます。
* `yaml.set(yamlConfig);`を使用してファイルをyamConfigurationで上書きします。
* yamlConfigurationは、取得時の状態のまま更新された値を参照しない為、以下のように使用します。
    ```Java
    Yaml yaml = new Yaml("config.yml", Example.getPlugin());
    // 値を取得する
    String str = yaml.get().getString("owner");
    // 値を設定する
    YamlConfiguration yamlConfig = yaml.get();
    yamlConfig.set("owner", "takumi3s");
    yaml.set(yamlConfig);
    ```


## ライセンス

* ©Azisaba Reincarnation