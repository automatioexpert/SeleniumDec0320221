/*
 * MIT License
 *
 * Copyright (c) 2018 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.eliasnogueira.test;

import com.eliasnogueira.BaseWeb;
import com.eliasnogueira.data.dynamic.BookingDataFactory;
import com.eliasnogueira.page.booking.AccountPage;
import com.eliasnogueira.page.booking.DetailPage;
import com.eliasnogueira.page.booking.RoomPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRoomWebTest extends BaseWeb {

    @Test(description = "Book a room")
    public void bookARoom() {
        var bookingInformation = BookingDataFactory.createBookingData();

        var accountPage = new AccountPage();
        accountPage.fillEmail(bookingInformation.getEmail());
        accountPage.fillPassword(bookingInformation.getPassword());
        accountPage.selectCountry(bookingInformation.getCountry());
        accountPage.selectBudget(bookingInformation.getDailyBudget());
        accountPage.clickNewsletter();
        accountPage.next();

        var roomPage = new RoomPage();
        roomPage.selectRoomType(bookingInformation.getRoomType());
        roomPage.next();

        var detailPage = new DetailPage();
        detailPage.fillRoomDescription(bookingInformation.getRoomDescription());
        detailPage.finish();

        assertThat(detailPage.getAlertMessage())
                .isEqualTo("Your reservation has been made and we will contact you shortly");
    }
}
