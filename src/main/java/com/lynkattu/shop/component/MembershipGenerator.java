package com.lynkattu.shop.component;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
    public class MembershipGenerator {
        private static final char[] SAFE_ALPHABET =
                "23456789ABCDEFGHJKLMNPQRSTUVWXYZ".toCharArray();

        public static String generateMembershipNumber() {
            Random random = new Random();
            // Generates an 8-character random ID like "4K7N9ZXP"
            String rawId = NanoIdUtils.randomNanoId(random, SAFE_ALPHABET, 8);

            // Format as "4K7N-9ZXP" for easier typing
            return rawId.substring(0, 4) + "-" + rawId.substring(4);
        }


}
