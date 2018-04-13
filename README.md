
平台的规则微服务

input: 实时的一条完整设备信息。 output: 发送给plugin的一条包含json的http。

function: 大致义务，每一规则有自己的filters[多个], processor[一个], 启动包含了处理plugin的相关参数、地址和附加数据。 每一条规则只要filter生效，该ruler即生效。
