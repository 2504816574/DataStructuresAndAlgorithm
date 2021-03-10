package com.t003_linkedlist;

import java.util.Stack;

/**
 * @auther Ashen One
 * @Date 2021/2/25
 * 单链表
 */
public class T01_SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
      /*  singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);*/

        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //更新
        // singleLinkedList.update(new HeroNode(4, "林冲2", "豹子头2"));

        //删除
        // singleLinkedList.del(2);
        // singleLinkedList.del(4);

        //测试一下 求单链表中有效节点的个数
        //System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));


        //测试一下看看是否得到了倒数第K个节点
        // HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
        // System.out.println("res=" + res);

        // reversetList(singleLinkedList.getHead());

        //显示一把
        reversePrint(singleLinkedList.getHead());
        singleLinkedList.list();
    }


    /**
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next; //遍历
        }
        return length;
    }

    /**
     * 找单链表中的倒数第k个结点 【新浪面试题】
     * 思路
     * 1. 编写一个方法，接收head节点，同时接收一个index
     * 2. index 表示是倒数第index个节点
     * 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
     * 5. 如果找到了，则返回该节点，否则返回nulll
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if (index <= 0 || length < index) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        HeroNode temp = head.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;

        }

        return temp;
    }

    /**
     * 将单链表反转
     */
    public static void reversetList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode temp = head.next;
        // 指向当前节点[temp]的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端

        while (temp != null) {
            //先暂时保存当前节点的下一个节点，因为后面需要使用
            next = temp.next;
            //将temp的下一个节点指向新的链表的最前端
            temp.next = reverseHead.next;
            //将temp 连接到新的链表上
            reverseHead.next = temp;
            //让temp后移
            temp = next;
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;

    }

    /**
     * 可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
     */

    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//空链表，不能打印
        }
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = head.next;
        //将链表的所有节点压入栈
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }

        //将栈中的节点进行打印,pop 出栈
        while (heroNodes.size() > 0) {
            //stack的特点是先进后出
            System.out.println(heroNodes.pop());
        }


    }


}

/**
 * 定义SingleLinkedList 管理我们的英雄
 */
class SingleLinkedList {
    private final HeroNode head = new HeroNode(0, "", "");


    /**
     * 返回头节点
     */
    public HeroNode getHead() {
        return head;

    }

    /**
     * 添加节点到单向链表
     * 思路，当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next 指向 新的节点
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                //当退出while循环时，temp就指向了链表的最后
                //将最后这个节点的next 指向 新的节点
                temp.next = heroNode;
                break;
            } else {
                temp = temp.next;
            }
        }

    }

    /**
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * (如果有这个排名，则添加失败，并给出提示)
     */


    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
                //下一个英雄编号大于要插入的编号，获得要插入的位置
            } else if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }

        }

        //判断flag 的值
        if (flag) {
            //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 修改节点的信息, 根据no编号来修改，即no编号不能改.
     * 说明
     * 1. 根据 newHeroNode 的 no 来修改即可
     */
    public void update(HeroNode newHeroNode) {
        //判空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        } else {
            HeroNode temp = head.next;
            while (true) {
                if (temp == null) {
                    System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
                    break;
                } else if (temp.no == newHeroNode.no) {
                    temp.name = newHeroNode.name;
                    temp.nickname = newHeroNode.nickname;
                    break;
                } else {
                    temp = temp.next;
                }
            }

        }

    }

    /**
     * 删除节点
     * 思路
     * 1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
     */
    public void del(int no) {
        if (head.next == null) {
            System.out.println("该链表为空");
        } else {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    System.out.printf("要删除的 %d 节点不存在\n", no);
                    break;
                } else if (temp.next.no == no) {
                    //找到节点，可以删除
                    temp.next = temp.next.next;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
    }


    /**
     * 显示链表[遍历]
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        } else {
            //因为头节点，不能动，因此我们需要一个辅助变量来遍历
            HeroNode temp = head.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                } else {
                    //输出节点的信息
                    System.out.println(temp);
                    //将temp后移
                    temp = temp.next;
                }

            }
        }

    }
}

/**
 * 定义HeroNode ，每个HeroNode 对象就是一个节点
 */
class HeroNode {
    /**
     * 编号
     */
    public int no;
    /**
     * 名字
     */
    public String name;
    /**
     * 称号
     */
    public String nickname;
    /**
     * 指向下一个节点
     */
    public HeroNode next;

    /**
     * 构造器
     *
     * @param no
     * @param name
     * @param nickname
     */
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * 为了显示方法，我们重新toString
     */

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}