/*
 * Copyright (C) 2019 Inera AB (http://www.inera.se)
 *
 * This file is part of sklintyg (https://github.com/sklintyg).
 *
 * sklintyg is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * sklintyg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.inera.intyg.schemas.contract.util;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class HashUtilityTest {

    @Test
    public void shouldReturnCorrectHashValue() {
        String payload = "1234567890";
        String hashedPayload = HashUtility.hash(payload);
        Assert.assertEquals("c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646", hashedPayload);
    }

    @Test
    public void shouldReturnEmptyHashConstantWhenPayloadIsNull() {
        String payload = null;
        String hashedPayload = HashUtility.hash(payload);
        Assert.assertEquals(HashUtility.EMPTY, hashedPayload);
    }

    @Test
    public void shouldReturnEmptyHashConstantWhenPayloadIsEmpty() {
        String payload = "";
        String hashedPayload = HashUtility.hash(payload);
        Assert.assertEquals(HashUtility.EMPTY, hashedPayload);
    }

    @Test
    public void threadSafeTest() {

        final int num = 10;

        Map<String, String> map = Stream.generate(UUID::randomUUID)
                .limit(num)
                .map(UUID::toString)
                .collect(Collectors.toMap(k -> k, k -> HashUtility.hash(k)));

        ExecutorService es = Executors.newFixedThreadPool(num);

        for (Map.Entry<String, String> e : map.entrySet()) {
            final AtomicBoolean rc = new AtomicBoolean(true);
            for (int i = 0; i < num; i ++) {
                es.execute(() -> {
                    final String h = HashUtility.hash(e.getKey());
                    if (!h.equals(e.getValue())) {
                        rc.set(false);
                    }
                });
                Assert.assertEquals(true, rc.get());
            }
        }
    }
}
