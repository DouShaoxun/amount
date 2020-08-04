package cn.dsx.amount;

import cn.dsx.amount.utils.RMBConvert;
import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class AmountApplicationTests {


    @Test
    void contextLoads() throws Exception {
        Random random = new Random();
        int k = 0;
        int Total = 100000;
        int max = 1000000000;
        // 整数测试
        for (int i = 0; i < Total; i++) {
            int original = random.nextInt(max);
            String bigAmount = Convert.digitToChinese(original);
            String smailAmount = RMBConvert.ChineseConvertToNumber(bigAmount);
            boolean flag = Convert.digitToChinese(Double.valueOf(smailAmount)).equals(bigAmount);
            //soutAmount(k, bigAmount, smailAmount, "Original: " + original);
            if (!flag) {
                soutAmount(k, bigAmount, smailAmount, "Original: " + original);
                throw new Exception("转换错误");
            }
            k++;
        }
        // 一位小数
        for (int i = 0; i < Total; i++) {
            double original = random.nextInt(max);
            original = original / 10;

            String bigAmount = Convert.digitToChinese(original);
            String smailAmount = RMBConvert.ChineseConvertToNumber(bigAmount);
            boolean flag = Convert.digitToChinese(Double.valueOf(smailAmount)).equals(bigAmount);
            //soutAmount(k, bigAmount, smailAmount, "Original: " + original);

            if (!flag) {
                soutAmount(k, bigAmount, smailAmount, "Original: " + original);
                throw new Exception("转换错误");
            }
            k++;
        }
        // 两位小数
        for (int i = 0; i < Total; i++) {
            double original = random.nextInt(max);
            original = original / 100;

            String bigAmount = Convert.digitToChinese(original);
            String smailAmount = RMBConvert.ChineseConvertToNumber(bigAmount);
            boolean flag = Convert.digitToChinese(Double.valueOf(smailAmount)).equals(bigAmount);
            //soutAmount(k, bigAmount, smailAmount, "Original: " + original);

            if (!flag) {
                soutAmount(k, bigAmount, smailAmount, "Original: " + original);
                throw new Exception("转换错误");
            }
            k++;
        }
        System.out.println("success: "+k);
    }



    private void soutAmount(int k, String bigAmount, String smailAmount, String s) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=====================================");
        System.out.println("K:" + k);
        System.out.println(s);
        System.out.println("Convert.digitToChinese: " + bigAmount);
        System.out.println("CNNMFilter.ChineseConvertToNumber: " + smailAmount);
        System.out.println("=====================================");
        System.out.println();
        System.out.println();
        System.out.println();
    }

}