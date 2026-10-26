# 项目进度

更新日期：2026-10-26

## 已完成

- 建立独立 Git 仓库与公开 GitHub 仓库 [qianwanwan/poker-lab](https://github.com/qianwanwan/poker-lab)，配置 main 跟踪 origin/main。
- 建立 Java 21 单模块 Maven 工程，配置 JUnit 5.11.4，工程配置已提交（4907679）。
- 完成 Suit、Rank、不可变 Card、值相等与非空校验（dfa53e0）。
- 完成标准 52 张牌堆、实际数量查询与只读快照（46244ce）。
- 完成从末尾抽牌、抽空异常与快照独立性验证（72a10ca）。
- 开发者完成 shuffle(Random random) 与五个洗牌测试，十七个测试全部通过。
- 协作约定已记录：功能经审查和测试通过后，由协作者清理已完成 TODO、提交并推送。

## 当前状态

- 牌与牌堆基础功能已通过当前验收，尚未实现牌型判断和完整牌局。
- 洗牌约定：只重排当前剩余牌，数量和内容不变；相同初始状态和随机种子可复现；空堆和单牌保持原样；null 随机源抛出 NullPointerException，牌堆保持不变。
- 抽牌约定：列表末尾为牌顶；移除并返回一张牌；空牌堆抛出 IllegalStateException，状态保持不变；旧快照不受影响。
- 尚无完整规则引擎或可运行客户端。
- 3D 方向暂定为 Blender 资源、Three.js 场景与 HTML/CSS 界面；尚未制作原型或验证性能。

## 下一步

1. 明确五张牌的输入边界、牌型顺序与平局规则。
2. 从高牌比较开始，逐步实现五张牌的牌型判断与比较。

本轮验证：mvn clean test 重新编译源码和测试，Tests run: 17, Failures: 0, Errors: 0, Skipped: 0，BUILD SUCCESS。牌型判断与后续牌局规则尚未实现或验证。
