from abstractMapper import abstractMapper
from domain.position import Position

class PositionMapper(abstractMapper):

    def __init__(self):
        super(PositionMapper, self).__init__()
        self.COLUMNS = 'PositionId, Title'

    def findStatement(self):
        return "SELECT %s FROM Position where PositionId = ? "%self.COLUMNS

    def find(self, domain_id):
        return self.abstractFind(domain_id)

    def doLoad(self, domain_id, rs):
        title = rs[1]
        return Position(domain_id, title)

