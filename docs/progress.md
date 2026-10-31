# 项目进度

更新日期：2026-10-31

## 已完成

- 建立独立 Git 仓库与公开 GitHub 仓库 [qianwanwan/poker-lab](https://github.com/qianwanwan/poker-lab)，配置 main 跟踪 origin/main。
- 建立 Java 21 单模块 Maven 工程，配置 JUnit 5.11.4，工程配置已提交（4907679）。
- 完成 Suit、Rank、不可变 Card、值相等与非空校验（dfa53e0）。
- 完成标准 52 张牌堆、实际数量查询与只读快照（46244ce）。
- 完成从末尾抽牌、抽空异常与快照独立性验证（72a10ca）。
- 完成 shuffle(Random random) 与五个洗牌测试，十七个测试全部通过（a51bcb7）。
- 完成 Rank 显式点数值、枚举构造器和只读访问方法，十九个测试全部通过，已提交并推送（96c0d73）。
- 完成 HighCardComparator，补齐单侧非法输入和平局异序用例，二十六个测试全部通过。
- 将原五张牌校验原样提取为包内 FiveCardHandValidator，供比较器和后续特征检测复用。
- 协作约定已记录：功能经审查和测试通过后，由协作者清理已完成 TODO、提交并推送。

## 当前状态

- 牌与牌堆基础功能已验收并提交，尚未实现牌型判断和完整牌局。
- 点数值已验收：TWO～TEN 为 2～10，J/Q/K/A 为 11/12/13/14；低 A 顺子的特殊处理留给牌型判断。
- 高牌比较已通过验收，尚未实现完整牌型识别。
- 高牌比较前提：调用方已确认双方属于高牌；比较器按点数降序逐项比较，忽略花色与输入顺序，保持输入不变。每手须有五张不同的非空 Card，空值抛出 NullPointerException，数量或重复牌问题抛出 IllegalArgumentException。
- 洗牌约定：只重排当前剩余牌，数量和内容不变；相同初始状态和随机种子可复现；空堆和单牌保持原样；null 随机源抛出 NullPointerException，牌堆保持不变。
- 抽牌约定：列表末尾为牌顶；移除并返回一张牌；空牌堆抛出 IllegalStateException，状态保持不变；旧快照不受影响。
- 尚无完整规则引擎或可运行客户端。
- 3D 方向暂定为 Blender 资源、Three.js 场景与 HTML/CSS 界面；尚未制作原型或验证性能。

## 下一步

1. 复用五张牌输入校验，准备同花特征检测与两个测试方法。
2. 再逐步实现顺子、点数分组和最终牌型识别。

本轮验证：修正验收案例后运行 mvn clean test，Tests run: 26, Failures: 0, Errors: 0, Skipped: 0，BUILD SUCCESS。完整牌型识别尚未实现。
