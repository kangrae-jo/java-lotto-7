package model;

import java.util.List;

public class LottoChecker {

    private final List<Integer> inputNumber;
    private final int bonusNumber;
    private boolean bonusFlag;

    public LottoChecker(List<Integer> inputNumber, int bonusNumber) {
        this.inputNumber = inputNumber;
        this.bonusNumber = bonusNumber;
    }

    public int[] checkLottos(List<Lotto> lottos) {
        // index 0~7은 각각 n개 일치 한다는 정보를 가진다.
        // x, x, x, 3개, 4개, 5개, 6개, 5개+보너스
        // ex) matchNumberCount[4] == 2는 4개일치하는 로또가 2개라는 의미이다.
        int[] matchNumberCount = new int[8];

        for (Lotto lotto : lottos) {
            int matchCount = checkLotto(lotto);
            matchNumberCount[matchCount]++;
            if (bonusFlag && matchCount == 5) {
                matchNumberCount[matchCount]--;
                matchNumberCount[matchCount + 2]++;
            }
        }
        return matchNumberCount;
    }

    public int checkLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        bonusFlag = checkBonus(lottoNumbers);
        lottoNumbers.retainAll(inputNumber);

        return lottoNumbers.size();
    }

    public boolean getBonusFlag() {
        return bonusFlag;
    }

    private boolean checkBonus(List<Integer> lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }
}